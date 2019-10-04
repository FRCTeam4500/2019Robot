# Modified 2019 Robot Code

This is a restructured version of the 2019 robot code, with the added feature of simulating the robot and working vision code.

## Project Organization

Due to the drastic difference in organization from standard WPILib projects, it is necessary to explain the project's structure.

### Unorganized Files

* Robot - This is the regular robot class. All subsystems and OI are created in this class.
* IMainOI and XboxOI - IMainOI declares all the methods that an OI must contain. IMainOI exists in order for multiple configurations to exist. XboxOI maps these methods to an xbox controller.
* RobotMap - This is a regular RobotMap class containing all the port numbers for controllers and motors.

### Automation

This package contains all automation related things, which is usually just commands.

### Components

Components are the smaller parts that make up a subsystem, like motors, encoders, solenoids, etc. Subsystems should use the interfaces provided so that the subsystem can be quickly configured to other similar components.

There are three important sub packages, each of which implement at least one of the component interfaces:

* Hardware - This package contains wrappers for all the real component implementations, such as the Talon SRX or the AHRS gyro.  
* Virtual - This package contains virtual component implementations. Their function is simulated on the computer, and it provides functions to get and set properties as necessary.
* Dashboard - This package contains an assortment of component decorators. Each of them wrap around other components and record the data that goes in and out of that component to the network tables. These values can be displayed in Shuffleboard, SmartDashboard, or any other network table interface.

### Subsystems

This is pretty similar to the regular subsystem folder, but each subsystem is grouped in its own folder. Each subsystem folder contains:

* Relevant subsystem commands (this was done so that it is easier to find commands by subsystem, rather than having all of them clumped together in a commands folder.)
* The subsystem class
* A subsystem specific OI if the subsystem can be "driven", e.g. a drivetrain or a turret constantly being set to a thumbstick position
* Factory classes for quick and easy configuration

### Utility

This folder contains tools that are not subsystems or components. It is somewhat miscellaneous, so feel free to put anything useful in this folder.
