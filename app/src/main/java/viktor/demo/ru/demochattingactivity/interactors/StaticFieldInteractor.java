package viktor.demo.ru.demochattingactivity.interactors;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Developer on 13.04.2018.
 */

public @interface StaticFieldInteractor {


        @StringDef({StaticField.OWNER, StaticField.ANIMAL})
        @Retention(RetentionPolicy.SOURCE)
        @interface StaticField{
            String OWNER = "owner";
            String ANIMAL = "animal";

    }
}
