package com.student.controller;

import com.student.dao.CountryDAO;
import com.student.dao.UserDAO;
import com.student.exception.CountryInvalidException;
import com.student.model.Country;
import com.student.model.User;
import com.student.utils.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "UserServlet", urlPatterns = {"/users", ""})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private CountryDAO countryDAO;

    private List<Country> countryList;
    private List<User> userList;

    public void init() {
        userDAO = new UserDAO();
        countryDAO = new CountryDAO();
        countryList = countryDAO.selectAll();
        userList = userDAO.selectAll();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }


    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        request.setAttribute("countryList", countryList);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User needEditUser = userDAO.select(id);
        request.setAttribute("countryList", countryList);
        request.setAttribute("needEditUser", needEditUser);
        request.getRequestDispatcher("WEB-INF/edit.jsp").forward(request, response);


    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Set<String> errors = new HashSet<>();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int idCountry = Integer.parseInt(request.getParameter("country"));

        User edited = new User(id, name, email, idCountry);
        validateUser(errors, edited, request);
        userDAO.update(edited);
        request.getRequestDispatcher("WEB-INF/edit.jsp").forward(request, response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        request.setAttribute("userList", userList);
        request.setAttribute("countryList", countryList);
        request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,
            ServletException {

        Set<String> errors = new HashSet<>();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int idCountry = Integer.parseInt(request.getParameter("country"));
        User newUser = new User(name, email, idCountry);

        validateUser(errors, newUser, request);

        if (errors.isEmpty()) {
            request.setAttribute("msg", "Add new user success!");
            userDAO.insert(newUser);
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("newUser", newUser);
        }
        request.setAttribute("countryList", countryList);
        request.getRequestDispatcher("WEB-INF/create.jsp").forward(request, response);
    }

    public User validateUser(Set<String> errors, User user, HttpServletRequest request) {


        if (user.getName().equals("")) {
            errors.add("Please fill your name! Upper case first letter");
        } else if (!ValidateUtils.isFullNameValid(user.getName())) {
            errors.add("Please fill your name with upper case first letter!");
        }


        if (user.getEmail().equals("")) {
            errors.add("Please fill your email! \nEx: abc@xyz.com");
        } else if (!ValidateUtils.isEmailValid(user.getEmail())) {
            errors.add("Please fill your email! \nEx: abc@xyz.com");
        }

        try {

            if (user.getIdCountry() == -1) {
                throw new CountryInvalidException("This country is not exist!");
            }
        } catch (NumberFormatException n) {
            errors.add("Choose right country!");
        } catch (CountryInvalidException c) {
            errors.add(c.getMessage());
        }

        return user;
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setAttribute("countryList", countryList);
        request.getRequestDispatcher("WEB-INF/create.jsp").forward(request, response);
    }
}
