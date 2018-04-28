package cap5;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class Swordman {
    public void block(String enemy) {
        System.out.println(this.getClass().getSimpleName() + "格挡11111111 " + enemy);
    }

    public void chop(String enemy) {
        System.out.println(this.getClass().getSimpleName() + "砍劈攻击" + enemy);
    }
}
