/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author dinht
 */
public class Paging extends TagSupport {

    private int totalpage;
    private int gap;
    private int pageindex;
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getgap() {
        return gap;
    }

    public void setgap(int gap) {
        this.gap = gap;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public String hyperlink(String href, String text) {
        return "<a class=\"hyperlink\" href=\"" + href + "\" >" + text + "</a>&nbsp;&nbsp;&nbsp;";
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            String result = "";
            if (pageindex > gap) {
                result += hyperlink(website + "?page=1", "First");
            }
            for (int i = gap; i >= 1; i--) {
                if (pageindex - i > 0) {
                    result += hyperlink(website + "?page=" + (pageindex - i), "" + (pageindex - i));
                }
            }

            result += "<span class=\"label\">" + pageindex + "</span>&nbsp;&nbsp;&nbsp;";

            for (int i = 1; i <= gap; i++) {
                if (pageindex + i <= totalpage) {
                    result += hyperlink(website + "?page=" + (pageindex + i), "" + (pageindex + i));
                }
            }
            if (pageindex < totalpage - gap) {
                result += hyperlink(website + "?page=" + totalpage, "Last");
            }

            pageContext.getOut().write(result);

        } catch (IOException ex) {
        }
        return SKIP_BODY;
    }
}
