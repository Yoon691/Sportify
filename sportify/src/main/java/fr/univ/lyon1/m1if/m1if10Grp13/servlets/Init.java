package fr.univ.lyon1.m1if.m1if10Grp13.servlets;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.univ.lyon1.m1if.m1if10Grp13.classes.Club;
import fr.univ.lyon1.m1if.m1if10Grp13.classes.Inscrit;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOClub;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOCreneau;
import fr.univ.lyon1.m1if.m1if10Grp13.dao.DAOInscrit;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Init", urlPatterns="/Init",loadOnStartup=1)
public class Init extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private ServletContext servletContext;
	private EntityManagerFactory factory;

	/**
	 * Instanciation des DAO et du factory.
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
    	this.servletContext = config.getServletContext();
    	this.factory = Persistence.createEntityManagerFactory("pu-sportify");
    	
    	DAOInscrit daoInscrit = new DAOInscrit(this.factory);
    	DAOClub daoClub = new DAOClub(this.factory);
    	DAOCreneau daoCreneau = new DAOCreneau(this.factory);
    	servletContext.setAttribute("daoInscrit", daoInscrit);
    	servletContext.setAttribute("daoClub", daoClub);
    	servletContext.setAttribute("daoCreneau", daoCreneau);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.servletContext.getRequestDispatcher("/index.jsp");
    }
}
