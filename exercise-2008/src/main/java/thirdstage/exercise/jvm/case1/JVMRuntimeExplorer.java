package thirdstage.exercise.jvm.case1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JVMRuntimeExplorer{

	/**
	 * Prints list of packages managed by the ClassLoader of this class. Prints
	 * to the standard out.
	 */
	public void PrintPackageList() throws Exception{

		// ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		ClassLoader classLoader = Class.forName("org.springframework.web.context.WebApplicationContext").getClassLoader();

		Package[] packages = Package.getPackages();

		List<PackageInfo> packageInfos = new ArrayList<PackageInfo>(200);
		PackageInfo packageInfo = null;

		for(Package pkg : packages){

			packageInfo = new PackageInfo(pkg.getName(), pkg.getImplementationTitle(), pkg.getImplementationVendor(), pkg.getImplementationVersion(), pkg
					.getSpecificationTitle(), pkg.getSpecificationVendor(), pkg.getSpecificationVersion());

			packageInfos.add(packageInfo);
		}

		Collections.sort(packageInfos);

		int i = 0;
		for(PackageInfo pkg : packageInfos){
			System.out.println("" + ++i + ", " + pkg.toString());
		}
	}
	
	/**
	 * internally enhanced method of {@link #PrintPackageList()}
	 */
	public void PrintPackageList2() throws Exception{

		// ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		ClassLoader classLoader = Class.forName("org.springframework.web.context.WebApplicationContext").getClassLoader();

		Package[] packages = Package.getPackages();
		
		assert(packages != null);
		if(packages == null){ return; }
		
		Arrays.sort(packages, new PackageComparator());
		
		
		for(int i = 0, n = packages.length; i < n; i++){
			System.out.println("" + (i + 1) + ", " + packages[i].getName());
		}
		System.out.println("All " + packages.length + " packages are printed.");

	}
	

	public static void main(String[] args) throws Exception{

		JVMRuntimeExplorer explorer = new JVMRuntimeExplorer();

		explorer.PrintPackageList2();

	}

	public static class PackageInfo implements Comparable<PackageInfo>{

		private String name = "";
		private String implementationTitle = "";
		private String implementationVendor;
		private String implementationVersion;
		private String specTitle;
		private String specVendor;
		private String specVersion;
		private int order = 1;

		public PackageInfo(){

		}

		public PackageInfo(String name, String implTitle, String implVendor, String implVer, String specTitle, String specVendor, String specVer){

			this.name = name;
			this.implementationTitle = implTitle;
			this.implementationVendor = implVendor;
			this.implementationVersion = implVer;
			this.specTitle = specTitle;
			this.specVendor = specVendor;
			this.specVersion = specVer;
		}

		@Override
		public int hashCode(){
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj){
			if(this == obj)
				return true;
			if(obj == null)
				return false;
			if(getClass() != obj.getClass())
				return false;
			final PackageInfo other = (PackageInfo)obj;
			if(name == null){
				if(other.name != null)
					return false;
			}else if(!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString(){
			return this.name + ", " + this.order + ", " + this.specTitle + ", " + this.specVendor + ", " + this.specVersion + ", " + this.implementationTitle
					+ ", " + this.implementationVendor + ", " + this.implementationVersion;
		}

		public int compareTo(PackageInfo otherInfo){
			return this.getName().compareTo(otherInfo.getName());

		}

		public int getOrder(){
			return order;
		}

		public void setOrder(int order){
			this.order = order;
		}

		public String getName(){
			return name;
		}

		public void setName(String name){
			this.name = name;
		}

		public String getImplementationTitle(){
			return implementationTitle;
		}

		public void setImplementationTitle(String implementationTitle){
			this.implementationTitle = implementationTitle;
		}

		public String getImplementationVendor(){
			return implementationVendor;
		}

		public void setImplementationVendor(String implementationVendor){
			this.implementationVendor = implementationVendor;
		}

		public String getImplementationVersion(){
			return implementationVersion;
		}

		public void setImplementationVersion(String implementationVersion){
			this.implementationVersion = implementationVersion;
		}

		public String getSpecTitle(){
			return specTitle;
		}

		public void setSpecTitle(String specTitle){
			this.specTitle = specTitle;
		}

		public String getSpecVendor(){
			return specVendor;
		}

		public void setSpecVendor(String specVendor){
			this.specVendor = specVendor;
		}

		public String getSpecVersion(){
			return specVersion;
		}

		public void setSpecVersion(String specVersion){
			this.specVersion = specVersion;
		}

	}

	public static class PackageComparator implements Comparator<Package>{

		public int compare(Package p1, Package p2){
			return p1.getName().compareTo(p2.getName());
		}
		
		

	}

}
