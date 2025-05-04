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

    private static final int relaxTime = 15_000;
    private static final long studyTimeMax = 6 * 60 * 1000;
    private static final long studyTimeMin = 3 * 60 * 1000;

    @SneakyThrows
    public static void main(String[] args) {
        while (true) {
            if (System.currentTimeMillis() > playTime) {
                SoundPlayUtil.playerSound("./sounds/Speech On.mp3");
                Thread.sleep(relaxTime);//中途休息
                SoundPlayUtil.playerSound("./sounds/Speech Off.mp3");
                playTime += rand.nextLong(studyTimeMin, studyTimeMax) + relaxTime;//下一次响铃时间
            }
            Thread.sleep(1200);
            System.out.printf("剩余时间: %ds\n", (playTime - System.currentTimeMillis()) / 1000);
        }
    }
}
