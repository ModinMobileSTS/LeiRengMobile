package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

public class GetTaxAction extends AbstractGameAction {

    private int increaseGold;
    private AbstractCreature target;
    private AbstractCreature source;
    private int[] damage;

    public GetTaxAction(AbstractCreature source, AbstractCreature target, int increasegold , int[] damage ){
        this.increaseGold=increasegold;
        this.target = target;
        this.source = source;
        this.damage = damage;
    }

    public void update(){
            for (AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
                if (!mo.isDead && !mo.isDying && !mo.halfDead) {
                    AbstractDungeon.player.gainGold(this.increaseGold);
                    for (int i = 0; i < this.increaseGold; ++i) {;
                        AbstractDungeon.effectList.add(new GainPennyEffect(this.source, mo.hb.cX, mo.hb.cY, this.source.hb.cX, this.source.hb.cY, true));
                    }
                }



            }
            this.addToBot(new DamageAllEnemiesAction(source,damage, DamageInfo.DamageType.NORMAL,AttackEffect.SLASH_HEAVY));
        this.isDone = true;
    }
}

