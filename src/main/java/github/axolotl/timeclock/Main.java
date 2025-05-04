package github.axolotl.timeclock;

import dczx.axolotl.util.SoundPlayUtil;
import lombok.SneakyThrows;

import java.sql.Time;
import java.util.Random;

/**
 * @author AxolotlXM
 * @since 2025/5/4 11:46
 */
public class Main {
    private static long playTime = System.currentTimeMillis();//响起铃声的时间
    private static final Random rand = new Random();

    @SneakyThrows
    public static void main(String[] args) {
        while (true) {
            if (System.currentTimeMillis() > playTime) {
                SoundPlayUtil.playerSound("./sounds/ringing_short.mp3");
                playTime += (long) (rand.nextDouble(3, 6) *60.0* 1000);
            }
            Thread.sleep(500);
            System.out.printf("剩余时间: %ds\n",( playTime - System.currentTimeMillis())/1000);
        }
    }
}
