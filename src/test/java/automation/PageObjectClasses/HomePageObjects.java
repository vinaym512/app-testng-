package automation.PageObjectClasses;

public class HomePageObjects {

    public static String getCarouselId(String osNameGlobal){
        if(osNameGlobal.equals("android")) {
            return "xpath=//*[@id='item_hero_carousel_pager']//*[@class='android.support.constraint.ConstraintLayout'][3]";
        }
        else {
            return "xpath=//*[@class='Martian.HeroCollectionViewCell']";
        }
    }

    public static String getVideoCatId(String osNameGlobal){
        if(osNameGlobal.equals("android")) {
            return "xpath=(//*[@id='home_page_recycler_view']/*/*[@id='item_standard_tile_carousel_text'])[4]";
        }
        else {
            return "xpath=//*//*[@class='Martian.StandardCarouselCollectionViewCell']";
        }
    }

    public static String getVideoToPlayId(String osNameGlobal){
        if(osNameGlobal.equals("android")) {
            return "xpath=(//*[@id='home_page_recycler_view']/*[./*[@id='item_standard_tile_carousel_text']])[4]/*/*[2]";
        }
        else {
            return "xpath=(//*[@class='Martian.StandardCarouselCollectionViewCell'])[2]";
        }
    }
}
