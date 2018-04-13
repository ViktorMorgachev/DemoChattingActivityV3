package viktor.demo.ru.demochattingactivity.interactors;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Developer on 13.04.2018.
 */

public @interface OwnerInteractor {


    @IntDef({OwnerField.ANASTASIA, OwnerField.MARINA, OwnerField.VIKTOR})
    @Retention(RetentionPolicy.SOURCE)
    @interface OwnerField{
        int ANASTASIA = 0;
        int VIKTOR = 1;
        int MARINA = 2;
    }
}
