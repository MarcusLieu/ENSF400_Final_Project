package com.coveros.training;

import com.coveros.training.domainobjects.Book;
import com.coveros.training.domainobjects.Borrower;
import com.coveros.training.persistence.LibraryUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

public class LibraryBorrowerListSearchServletTests {

    private static final String RESULT_JSP = "result.jsp";
    public static final String A_BORROWER = "abe borrower";
    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    private LibraryBorrowerListSearch libraryBorrowerListSearch;
    private final RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);
    private LibraryUtils libraryUtils = Mockito.mock(LibraryUtils.class);


    @Before
    public void before() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        libraryBorrowerListSearch = spy(new LibraryBorrowerListSearch());
        LibraryBorrowerListSearch.libraryUtils = this.libraryUtils;
    }

    /**
     * If we don't pass a name or an id, we'll get a list of all borrowers
     */
    @Test
    public void testListAllBorrowers() {
        when(request.getRequestDispatcher("result.jsp")).thenReturn(requestDispatcher);

        // act
        libraryBorrowerListSearch.doGet(request, response);

        // verify that the correct redirect was chosen.
        verify(libraryUtils).listAllBorrowers();
    }

    /**
     * If we pass an id, we'll get a particular borrower
     */
    @Test
    public void testSearchById() {
        when(request.getRequestDispatcher("result.jsp")).thenReturn(requestDispatcher);
        when(request.getParameter("id")).thenReturn("1");
        // the following is just to avoid a null pointer exception when the test succeeds
        when(libraryUtils.searchForBorrowerById(1)).thenReturn(Borrower.createEmpty());

        // act
        libraryBorrowerListSearch.doGet(request, response);

        // verify that the correct redirect was chosen.
        verify(libraryUtils).searchForBorrowerById(1);
    }

    /**
     * If we pass a name, we'll get a particular borrower
     */
    @Test
    public void testSearchByName() {
        when(request.getRequestDispatcher("result.jsp")).thenReturn(requestDispatcher);
        when(request.getParameter("name")).thenReturn(A_BORROWER);
        // the following is just to avoid a null pointer exception when the test succeeds
        when(libraryUtils.searchForBorrowerByName(A_BORROWER)).thenReturn(Borrower.createEmpty());

        // act
        libraryBorrowerListSearch.doGet(request, response);

        // verify that the correct redirect was chosen.
        verify(libraryUtils).searchForBorrowerByName(A_BORROWER);
    }

}
