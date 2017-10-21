package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.ClotherDOM;
import model.Clother;


/**
 * Servlet implementation class ClotheController
 */
@WebServlet("/ClotherController")
public class ClotherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Clother clother;
	private List<Clother> clothers;
	private ClotherDOM clotherDOM;
	private List<String> ids = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClotherController() {
        super();
        clother = new Clother(); 
        clothers= new ArrayList<Clother>();
        clotherDOM = new ClotherDOM();
        // TODO Auto-generated constructor stub
    }

    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btn_save")!=null) {
			clother.setJeans(request.getParameter("jeans"));
			clother.setShirt(request.getParameter("shirt"));
			clother.setCoat(request.getParameter("coat"));
			
			if(clother.getId()=="") {
				String newId= "SUP"+String.format("%05d", 1);
				clother.setId(newId);;
				
				if (clothers.size()>0) {
					ids.clear();
					for (Clother p: clothers) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "SUP"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
							clother.setId(newId);
						break;
						}
					}
				}
				System.out.println(clother);
				clotherDOM.add(clother);
			}else {
				clotherDOM.update(clother);
			}
			clothers= clotherDOM.getClother();
			request.setAttribute("clothers", clothers);
			request.getRequestDispatcher("clother_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			clother = new Clother();
			request.getRequestDispatcher("clother_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				clother = clotherDOM.findById(id);
				
			}catch (Exception e) {
				
				clother = new Clother();
			}
			request.setAttribute("clother", clother );
			
			request.getRequestDispatcher("clother_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			clotherDOM.delete(id);
			clothers = clotherDOM.getClother();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("clothers", clothers);
			request.getRequestDispatcher("clother_list.jsp").forward(request, response);
		}else {
			clothers = clotherDOM.getClother();
			request.setAttribute("clothers", clothers);
			request.getRequestDispatcher("clother_list.jsp").forward(request, response);
		}
			
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


