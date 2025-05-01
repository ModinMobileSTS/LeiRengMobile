package androidTestMod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class YiCutAction extends AbstractGameAction {

    private int damage;

    public YiCutAction( int damage){
        this.damage = damage;
    }

    public void update(){
        this.addToBot(new DamageAllEnemiesAction(AbstractDungeon.player,this.damage, DamageInfo.DamageType.NORMAL,AttackEffect.SLASH_HORIZONTAL));
        this.isDone=true;
    }

}
