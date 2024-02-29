package pkg06_upload;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 5,
                 maxRequestSize = 1024 * 1024 * 50)

public class Upload extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  // 업로드 경로 (톰캣 내부 경로)
	  // RealPath : ~ \.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\01_servlet
	  String uploadPath = request.getServletContext().getRealPath("upload"); // 프로젝트 영역 
	  File uploadDir = new File(uploadPath);
	  if(!uploadDir.exists()) {
	    uploadDir.mkdirs();
	  }
	  
	  // 첨부된 파일 정보
	  Collection<Part> parts = request.getParts(); // Collection 은 일반 for 문으로 돌리지 않는다.
	  
	  for (Part part : parts) {
	    // System.out.println(part.getName() + ", " + part.getContentType() + ", " + part.getSize() + ", " + part.getSubmittedFileName());
	    // System.out.println(part.getHeader("Content-Disposition"));
	    String originalFilename = null; // 원래 이름. 
	    if(part.getHeader("Content-Disposition").contains("filename")) {
	      if(part.getSize() > 0) {
	        originalFilename = part.getSubmittedFileName();	        
	      }
	    }
	    String filesystemName = null;
	    if(originalFilename !=null) {
	      filesystemName = originalFilename + "_" + System.currentTimeMillis();
	    }
	    System.out.println(originalFilename);
	  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
