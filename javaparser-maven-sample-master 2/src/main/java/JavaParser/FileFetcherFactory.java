package JavaParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFetcherFactory {
    public Loader checkFile(String filePath) {

        if(checkUrl(filePath)){
            return new UrlLoader();
        }
        else if(checkFilePath(filePath)){
            return new InternalFileLoader();
        }
        else
            return null;
    }

    public Boolean checkUrl(String filePath){
        String regex = "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";

        Pattern p = Pattern.compile(regex);

        if (filePath == null) {
            return false;
        }

        Matcher m = p.matcher(filePath);
        return m.matches();
    }

    public boolean checkFilePath(String filePath){
        String regex = "^(([a-zA-Z]:)|((\\\\|/){1,2}\\w+)\\$?)((\\\\|/)(\\w[\\w ]*.*))+\\.([a-zA-Z0-9]+)$";

        Pattern p = Pattern.compile(regex);

        if (filePath == null) {
            return false;
        }

        Matcher m = p.matcher(filePath);
        return m.matches();
    }

}
