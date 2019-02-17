package frc.robot.utility;

import org.opencv.core.Mat;
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

    private void createSimpleStream(){
        CameraServer.getInstance().startAutomaticCapture(id);    
    }

    private void createComplexStream(){
        new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(id);
            camera.setResolution(640, 480);
            
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
            
            Mat source = new Mat();
            Mat output = new Mat();
            
            while(!Thread.interrupted()) {
                cvSink.grabFrame(source);
                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
                outputStream.putFrame(output);
            }
        }).start();     
    }
}