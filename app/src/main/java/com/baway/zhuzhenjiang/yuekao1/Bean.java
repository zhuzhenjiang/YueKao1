package com.baway.zhuzhenjiang.yuekao1;

import java.util.List;

/**
 * 作者：朱振江 on 2017/3/4 0004 09:46
 * 邮箱：zzjdys@Gmail.com
 * 类用途:
 */


public class Bean {

    

    private String message;
    private int status;
    private List<RsBean> rs;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<RsBean> getRs() {
        return rs;
    }

    public void setRs(List<RsBean> rs) {
        this.rs = rs;
    }

    public static class RsBean {
        

        private boolean check;
        private String dirName;
        private int id;
        private List<ChildrenBeanX> children;

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public String getDirName() {
            return dirName;
        }

        public void setDirName(String dirName) {
            this.dirName = dirName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {
            

            private String dirName;
            private int id;
            private String imgApp;
            private boolean isHeader;
            private List<ChildrenBean> children;

            public String getDirName() {
                return dirName;
            }

            public void setDirName(String dirName) {
                this.dirName = dirName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImgApp() {
                return imgApp;
            }

            public void setImgApp(String imgApp) {
                this.imgApp = imgApp;
            }

            public boolean isIsHeader() {
                return isHeader;
            }

            public void setIsHeader(boolean isHeader) {
                this.isHeader = isHeader;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * children : []
                 * dirName : 一段奶粉
                 * id : 100007005
                 * imgApp : http://sale.suning.com/act/20140808/milk/1.png
                 * isHeader : false
                 */

                private String dirName;
                private int id;
                private String imgApp;
                private boolean isHeader;
                private List<?> children;

                public String getDirName() {
                    return dirName;
                }

                public void setDirName(String dirName) {
                    this.dirName = dirName;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImgApp() {
                    return imgApp;
                }

                public void setImgApp(String imgApp) {
                    this.imgApp = imgApp;
                }

                public boolean isIsHeader() {
                    return isHeader;
                }

                public void setIsHeader(boolean isHeader) {
                    this.isHeader = isHeader;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }
    }
}
