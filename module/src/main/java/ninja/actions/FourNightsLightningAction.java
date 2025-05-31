package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class FourNightsLightningAction extends AbstractGameAction {

    private int count;
    private AbstractCard card;

    public FourNightsLightningAction(AbstractCard card, int count ){
        this.card = card;
        this.count = count;
    }

    public void update(){

        for(int i=0 ; i < this.count ; i++){
            for(int j=0 ; j<4 ;j++ ) {
                this.addToBot(new AttackDamageRandomEnemyAction(this.card, AttackEffect.LIGHTNING));
            }
            this.addToBot(new GainEnergyAction( 1 ));
            this.addToBot(new DrawCardAction(AbstractDungeon.player, 1 ));
        }

        this.isDone=true;
    }

}
