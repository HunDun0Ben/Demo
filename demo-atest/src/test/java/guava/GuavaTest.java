package guava;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GuavaTest {

    @Test
    public void StringsTest(){
        System.out.println(Joiner.on(';').join(Arrays.asList("a","b","c")));
    }

    @Test
    public void splitterTest(){
        String str = ",a,,b,";
        Iterable<String> iterable = Splitter.on(",").split(str);
        List list = Lists.newArrayList(iterable);
        System.out.println(MoreObjects.toStringHelper(list).toString());
    }


}
