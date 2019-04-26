package unit;

import java.util.List;

/**
 * Created by Ice on 2019/3/8.
 */
public class PageUtil<T> {
    private int pageSize = 20;//每页显示的记录数
    private int totalCount;//总记录数
    private int totalPageCount;//总页数
    private int pageNum = 1;//当前页
    private List<T> data;//页面要显示的数据
    private int pageIndex;//

    public int getPageIndex() {
        pageIndex = (pageNum-1)*pageSize;
        return pageIndex;
    }

    public int getTotalPageCount() {
        //如果总资源数对页面容量取余等于0，那么总页数为总资源数对页面容量取商
        //否则，将结果+1
        totalPageCount =totalCount%pageSize==0? totalCount/pageSize:totalCount/pageSize+1;
        return totalPageCount;
    }
    public void setPageNum(int pageNum) {
        if(pageNum<1){
            pageNum = 1;
        }else if(pageNum>getTotalPageCount()){
            pageNum = totalPageCount;
        }
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }



    public int getPageNum() {
        return pageNum;
    }



    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
