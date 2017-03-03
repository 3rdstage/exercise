
Exercise project to manage Eclipse Plug-in Project (PDE) using Maven via tycho.
Important things to note are :

* The project need PDE nature.
* The project doesn't need Maven nature.
* For more on the structure of this project, refer http://git.eclipse.org/c/linuxtools/org.eclipse.linuxtools.git/tree/libhover/org.eclipse.linuxtools.cdt.libhover.glibc
* Tycho automatically download necessary dependencies for the project from p2 repository! 
* Two type of eclipse plug-in errors still remain, but they don't causes problems in Maven's build process.
** Bundle resolution problem with MANIFEST.MF
** Unknown extension point with plugin.xml
