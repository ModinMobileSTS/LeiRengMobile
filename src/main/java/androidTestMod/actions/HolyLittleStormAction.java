package androidTestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

public class HolyLittleStormAction extends AbstractGameAction {
    private AbstractPlayer p;
    private int damage;
    private int amount;

    public HolyLittleStormAction(AbstractPlayer p , int damage,int amount) {
        this.p = p;
        this.damage = damage;
        this.amount = amount;
    }

    public void update(){
        int count=amount;
        if (p.hasRelic("Chemical X")) {
            count += 2;
            p.getRelic("Chemical X").flash();
        }
        for(int i=0 ; i< count ; i++) {
            this.addToTop(new PlaySoundAction("YEEART"));
            this.addToTop(new DamageRandomEnemyAction(new DamageInfo(p,this.damage, DamageInfo.DamageType.NORMAL), AttackEffect.BLUNT_HEAVY));
        }
        this.isDone = true;
    }

}
