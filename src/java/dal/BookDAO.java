/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import model.BookChapters;

/**
 *
 * @author dinht
 */
public class BookDAO extends BaseDAO<Book> {

    @Override
    public ArrayList<Book> all() {
        try {
            ArrayList<Book> books = new ArrayList<>();
            String sql = "select * from Books";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Book b = new Book();
                b.setBookID(rs.getString("BookID"));
                b.setAuthor(rs.getString("Author"));
                b.setBookName(rs.getString("BookName"));
                b.setImg(rs.getString("Img"));
                b.setReview(rs.getString("Review"));
                b.setType(rs.getString("Type"));
                books.add(b);
            }
            return books;
        } catch (Exception e) {
        }
        
        File f = new File("test.txt");
        if(f == null) try {
            f.createNewFile();
            ObjectInputStream input = new ObjectInputStream(new DataInputStream(new FileInputStream(f)));
            ObjectOutputStream output = new ObjectOutputStream(new DataOutputStream(new FileOutputStream(f)));
        } catch (IOException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    ArrayList<Object> readFromFile(File f){
        ArrayList<Object> workers = new ArrayList<>();
        //read...
        return workers;
    }
    @Override
    public Book get(String BookID) {
        try {

            String sql = "select * from Books where BookID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, BookID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Book b = new Book();
                b.setBookID(rs.getString("BookID"));
                b.setAuthor(rs.getString("Author"));
                b.setBookName(rs.getString("BookName"));
                b.setImg(rs.getString("Img"));
                b.setReview(rs.getString("Review"));
                b.setType(rs.getString("Type"));
                return b;
            }

        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void insert(Book model) {
        try {
            String sql = "insert into Books\n"
                    + "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getBookID());
            statement.setString(2, model.getAuthor());
            statement.setString(3, model.getBookName());
            statement.setString(4, model.getImg());
            statement.setString(5, model.getReview());
            statement.setString(6, model.getType());
            statement.executeUpdate();

            sql = "insert into User_Library\n"
                    + "values (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, model.getAuthor());
            statement.setString(2, model.getBookID());
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Book model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String BookID) {
        try {
            String sql = "delete from User_Library\n"
                    + "where BookID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, BookID);
            statement.executeUpdate();
        } catch (Exception ex) {
        }
    }

    public int countAllBook() {
        String sql = "select count(*) as TotalRow from Books";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("TotalRow");
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public ArrayList<Book> pagingAllBook(int PageIndex, int PageCount) {
        try {
            ArrayList<Book> books = new ArrayList<>();
            String sql = "select * from \n"
                    + "(select ROW_NUMBER() over (order by BookID)as rn, *\n"
                    + "from Books\n"
                    + ") as tbl1\n"
                    + "where rn >= (? - 1) * ? - 1 and rn <= ? * ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, PageIndex);
            statement.setInt(2, PageCount);
            statement.setInt(3, PageIndex);
            statement.setInt(4, PageCount);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBookID(rs.getString("BookID"));
                b.setAuthor(rs.getString("Author"));
                b.setBookName(rs.getString("BookName"));
                b.setImg(rs.getString("Img"));
                b.setReview(rs.getString("Review"));
                b.setType(rs.getString("Type"));
                books.add(b);
            }
            return books;
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<String> getChapter(String BookID, int Chapter) {
        try {
            ArrayList<String> chapter = new ArrayList<>(); //chapter[0] as ChapterName and chapter[1] as ChapterContent
            String sql = "select c.ChapterName, c.ChapterContent "
                    + "from Books b inner join Book_Content c "
                    + "on b.BookID = c.BookID "
                    + "where b.BookID like ? and c.Chapter = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, BookID);
            statement.setInt(2, Chapter);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                chapter.add(rs.getString("ChapterName"));
                chapter.add(rs.getString("ChapterContent"));
            }
            return chapter;
        } catch (Exception e) {
        }
        return null;
    }

    public int countChapter(String BookID) {
        try {
            int total;
            String sql = "select count(*) as totalchapter from Book_Content\n"
                    + "where BookID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, BookID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("totalchapter");
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public ArrayList<BookChapters> getAllChapterOf(String BookID) {
        try {
            ArrayList<BookChapters> chapters = new ArrayList<>();
            String sql = "select Chapter, ChapterName from Book_Content\n"
                    + "where BookID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, BookID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BookChapters bc = new BookChapters();
                bc.setChapID(Integer.parseInt(rs.getString("Chapter")));
                bc.setChapterName(rs.getString("ChapterName"));
                chapters.add(bc);
            }
            return chapters;
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Book> search(String sql) {
        try {
            ArrayList<Book> books = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBookID(rs.getString("BookID"));
                b.setAuthor(rs.getString("Author"));
                b.setBookName(rs.getString("BookName"));
                b.setImg(rs.getString("Img"));
                b.setReview(rs.getString("Review"));
                b.setType(rs.getString("Type"));
                books.add(b);
            }
            return books;
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Book> getLibrary(String username) {
        try {
            ArrayList<Book> books = new ArrayList<>();
            String sql = "select * from User_Library l inner join Books b\n"
                    + "on l.BookID = b.BookID\n"
                    + "where Username = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBookID(rs.getString("BookID"));
                b.setAuthor(rs.getString("Author"));
                b.setBookName(rs.getString("BookName"));
                b.setImg(rs.getString("Img"));
                b.setReview(rs.getString("Review"));
                b.setType(rs.getString("Type"));
                books.add(b);
            }
            return books;
        } catch (Exception e) {
        }
        return null;
    }

    public void edit(String BookID, String ChapterID, String Chaptername, String Content) {
        try {
            String sql = "update Book_Content\n"
                    + "set ChapterName = ?, ChapterContent = ?\n"
                    + "where BookID = ? and Chapter = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Chaptername);
            statement.setString(2, Content);
            statement.setString(3, BookID);
            statement.setString(4, ChapterID);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addChapter(String BookID, String ChapterID, String ChapterName, String Content) {
        try {
            String sql = "insert into Book_Content\n"
                    + "values (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, BookID);
            statement.setString(2, ChapterID);
            statement.setString(3, ChapterName);
            statement.setString(4, Content);
            statement.executeUpdate();
        } catch (Exception e) {
        }
    }
}
