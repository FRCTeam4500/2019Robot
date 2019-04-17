package frc.robot.utility;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

public class CameraInstance {
    
    private StreamType type;
    private int id;
    
    public enum StreamType {
        SIMPLE, COMPLEX;
    }

    public CameraInstance(StreamType type, int id) {
        this.type = type;
        this.id = id;
    }

    public void start(){
        if (type == StreamType.SIMPLE) {
            createSimpleStream();
        } else if (type == StreamType.COMPLEX) {
            createComplexStream();
        }        
    }

    private void createSimpleStream() {
        CameraServer.getInstance().startAutomaticCapture(id);    
    }

    private void createComplexStream() {
        new Thread(() -> {
            int w = 160;
            int cX = 60;
            int h = 120;
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(w, h);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Flipped", w, h);
            // System.out.println("Before loop");
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            // // Size size = source.size();
            // // Mat M = Imgproc.getRotationMatrix2D(new Point(size.width/2, size.height/2), 180, 1);
            // System.out.println("Before loop");
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                if (!source.empty()) {
                    Imgproc.line(source, new Point(cX, 0), new Point(cX, h), new Scalar(255, 0, 0), 1);

                    // Imgproc.line(source, new Point(w/2, 0), new Point(w/2, h), new Scalar(255, 0, 0), 1);
                    // Imgproc.line(source, new Point(w/4, 0), new Point(w/4, h), new Scalar(255, 0, 0), 1);
                    // Imgproc.line(source, new Point((w/4)*3, 0), new Point((w/4), h), new Scalar(255, 0, 0), 1);
                    Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                    outputStream.putFrame(output);
                }
                // System.out.println(output.get(0, 0));
            // //     // Imgproc.warpAffine(output, output, M, size);
            }
        }).start();     
    }
}