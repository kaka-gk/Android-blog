

Fragment嵌套Fragment，主页Fragment切换时，内嵌套的Fragment页面不显示

------


#####


被嵌套的Fragment如果包含ViewPager，要使用getChildFragmentManager(),而不是getSupportFragmentManager();
