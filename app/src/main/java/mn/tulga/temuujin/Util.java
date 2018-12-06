package mn.tulga.temuujin;

import android.content.Context;
import android.graphics.drawable.Drawable;



public class Util {

    public static Drawable getDrawable(String name, Context context) {

        try {
            int resourceId =
                    context.getResources().getIdentifier(name, "mipmap", context.getPackageName());
            return context.getResources().getDrawable(resourceId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
