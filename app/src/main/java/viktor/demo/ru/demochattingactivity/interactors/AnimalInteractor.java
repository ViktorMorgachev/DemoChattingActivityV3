package viktor.demo.ru.demochattingactivity.interactors;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Developer on 13.04.2018.
 */

public @interface AnimalInteractor {


    @IntDef({AnimalField.Cat, AnimalField.Bird, AnimalField.Dog})
    @Retention(RetentionPolicy.SOURCE)
    @interface AnimalField{
        int Dog = 2;
        int Cat = 1;
        int Bird = 0;
    }
}
