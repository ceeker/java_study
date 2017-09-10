package job.demo;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Created by vectorzhang on 2017/9/9.
 */
public class MySimpleJob implements SimpleJob {
    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                sout(0);
                break;
            case 1:
                sout(1);
                break;
            case 2:
                sout(2);
                break;
            // case n: ...
        }
    }

    private void sout(int item) {
        System.out.println("item:" + item);
    }
}
