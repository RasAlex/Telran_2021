import org.junit.jupiter.api.Test;
import telran.regexp.tools.PhotoSelector;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PhotoSelectorTest {
    private static final  String[] pictures =
            {
            "Paris\\20140101_090000.jpg",
            "Paris\\20140201_121005.jpg",
            "Paris\\20150301_211035.jpg",
            "Paris\\20150401_110023.gif",
            "Paris\\20150401_181705.jpg",
            "Paris\\20150501_231035.gif",
            "London\\20140205_090000.jpg",
            "London\\20140205_121005.jpg",
            "London\\20140601_211035.gif",
            "London\\20151001_110023.jpg",
            "London\\20151001_121705.jpg",
            "London\\20151001_231035.jpg",
            "Chicago\\20150301_120001.png",
            "Chicago\\20151111_232000.png"
    };
@Test
    void testAllEuropePictures() {
    String regex = "^(Paris|London)";
    String[] expected = {
            "Paris\\20140101_090000.jpg",
            "Paris\\20140201_121005.jpg",
            "Paris\\20150301_211035.jpg",
            "Paris\\20150401_110023.gif",
            "Paris\\20150401_181705.jpg",
            "Paris\\20150501_231035.gif",
            "London\\20140205_090000.jpg",
            "London\\20140205_121005.jpg",
            "London\\20140601_211035.gif",
            "London\\20151001_110023.jpg",
            "London\\20151001_121705.jpg",
            "London\\20151001_231035.jpg"
    };
    String[] actual = PhotoSelector.selectPictures(pictures, regex);
    assertArrayEquals(expected, actual);
}
    @Test
     void testAllAutumnPictures(){
        String regex = "\\d{4}(09|1[01])\\d{2}_";
        String[] expected ={
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20151111_232000.png"
        };
        String[] actual = PhotoSelector.selectPictures(pictures,regex);
        assertArrayEquals(expected,actual);
    }
    @Test
    void testAll2015SpringPictures(){
        String regex ="(2015)(0[345])\\d{2}_";
        String[] expected  = {
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_110023.gif",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "Chicago\\20150301_120001.png"
        };
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        assertArrayEquals(expected, actual);
    }
    @Test
    void testAllNightPictures(){
        String regex ="_(1[89]|2[0-3]|00)";
        String[] expected  = {
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_181705.jpg",
                "Paris\\20150501_231035.gif",
                "London\\20140601_211035.gif",
                "London\\20151001_231035.jpg",
                "Chicago\\20151111_232000.png"
        };
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        assertArrayEquals(expected, actual);
}
    @Test
    void testAllNightPicturesFromChicago(){
        String regex ="^(Chicago).*_(1[89]|2[0-3]|00)";
        String[] expected  = {
                "Chicago\\20151111_232000.png"
        };
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        assertArrayEquals(expected, actual);
    }
    @Test
    void testAllJpgAndPngPictures(){
        String regex ="(\\.jpg)|(\\.png)";
        String[] expected = {
                "Paris\\20140101_090000.jpg",
                "Paris\\20140201_121005.jpg",
                "Paris\\20150301_211035.jpg",
                "Paris\\20150401_181705.jpg",
                "London\\20140205_090000.jpg",
                "London\\20140205_121005.jpg",
                "London\\20151001_110023.jpg",
                "London\\20151001_121705.jpg",
                "London\\20151001_231035.jpg",
                "Chicago\\20150301_120001.png",
                "Chicago\\20151111_232000.png"
        };
        String[] actual = PhotoSelector.selectPictures(pictures, regex);
        assertArrayEquals(expected, actual);
    }
}