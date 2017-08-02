

Android命名规范

------

 * xml
     

    a)如果是Activity,Fragment的布局命名以act_[模块名]_功能，比如act_login.xml
    
    b)id命名以View简写_功能,比如btn_login,txt_user_name
    
    c)ListView的xml以item_[模块名]_功能，比如item_live_list.xml

    d)如果是部件以component_[模块名]_功能，比如component_home_tab.xml

    e)如果是dialog以dialog_[模块名]_功能，比如dialog_share.xml

    ps:xml 命名采用小写

 
 * icon
    
    a)icon都以icon开头，命名规范为icon_功能_[状态]，比如icon_arrorw_left，icon_btn_focus,icon_btn_normal

    b)Image以img开头,命名规范为img_[模块名]_功能,比如img_home_title


 * 资源(drawable)
   
    a)选择器以selector开头,命名规范为selector_[模块名]_功能，selector_login_btn
    
    b)背景以bg开头,命名规范为bg_[模块名]_功能

    ps:命名都采用小写

 * 资源(String)
   
    a)共用的以common开头,命名规范为common_功能
     
    b)消息提示以msg_[模块名]+功能， 比如msg_login_title

    c)xml里提示以txt_[模块名]+功能 ,txt_user_name


 * 资源(color)
 
    a)共用的颜色，命名规范为颜色名，比如red

    c)普通颜色,以color_颜色_颜色值c_gray_f5f5f5

 * 类,接口

    a)类，接口名单词第一个字母大写

    b)普通变量名采用驼峰命名
   
    c)被final static 修饰的变量名都大写


 ＊包

    包名命名全部为小写

