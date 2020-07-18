//package co.mst.elastic;

import vtk.vtkNativeLibrary;
import vtk.vtkImageData;
import vtk.vtkDoubleArray;


public class BasicTest1 {

	// -----------------------------------------------------------------
	// Load VTK library and print which library was not properly loaded
	static {
		if (!vtkNativeLibrary.LoadAllNativeLibraries()) {
	      for (vtkNativeLibrary lib : vtkNativeLibrary.values()) {
	        if (!lib.IsLoaded()) {
	          System.out.println(lib.GetLibraryName() + " not loaded");
	        }
	      }
	    }
	    vtkNativeLibrary.DisableOutputWindow(null);
    }
	
	
	public static void test1() {
		
		System.out.println("\n*************\ntest1\n*************\n");
		
		vtkImageData img = new vtkImageData();
		
		
		int [] dims={2,3,4};
		double [] spc={1.,1.,1.};
		double [] org={1.,1.,1.};
		img.SetDimensions(dims);
		img.SetSpacing(spc);
		img.SetOrigin(org);
		
		
		vtkDoubleArray vtkArr = new vtkDoubleArray();
		vtkArr.SetName("MyData");
		for(int i=0;i<24;i++) {
			vtkArr.InsertNextValue(i);
		}
		img.GetPointData().SetScalars(vtkArr);
		
		int m=0;
		for(int i2=0;i2<dims[2];i2++) {
			for(int i1=0;i1<dims[1];i1++) {
				for(int i0=0;i0<dims[0];i0++) {
					double vv=img.GetScalarComponentAsDouble(i0,i1,i2,0);
					System.out.println(i2+", "+i1+", "+i0+" vv="+vv);
				
				}	
			}
		}
		
		int [] idims = img.GetDimensions();
		System.out.println("Image Data dimensions= "+idims[0]+", "+idims[1]+", "+idims[2]);
		  
		// and so on...
	}
	
	
	public static void main(String[] args){
		
		System.out.println("\n*************\nBasic VTK Test\n*************\n");
		test1();
	}

}
