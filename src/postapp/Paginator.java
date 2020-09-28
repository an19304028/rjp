package postapp;

import java.sql.SQLException;

public class Paginator {
    private int perPages;
    private int pages;
    private int currentPage;
    private int posts;

    public Paginator(int perPages, int currentPage) throws SQLException, ClassNotFoundException {
        OracleAccess access = new OracleAccess();
        posts = access.howManyPosts();
        access.disconnect();

        this.perPages = perPages;
        this.currentPage = currentPage;

        if(posts%perPages==0) {
            pages = posts/perPages;
        } else {
            pages = (posts / perPages) + 1;
        }
    }

    public int getPages() {
        return pages;
    }

    public int getFrontPostNum() {
        return (perPages*(currentPage-1))+1;
    }

    public int getBackPostNum() {
        if(perPages*currentPage>posts) {
            return posts;
        } else {
            return perPages * currentPage;
        }
    }

    public int getFrontPageNum() {
        if(currentPage<=pages) {
            return 1;
        } else {
            return currentPage-(perPages/2);
        }
    }

    public int getBackPageNum() {
        if(currentPage <= 5 && pages<=5) {
            return pages;
        } else if(currentPage==pages) {
            return currentPage;
        } else{
            return currentPage+(perPages/2);
        }
    }
}
