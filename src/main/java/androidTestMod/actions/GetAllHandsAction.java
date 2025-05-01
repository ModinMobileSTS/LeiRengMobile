package androidTestMod.actions;

import com.megacrit.cardcrawl.cards.AbstractCard;
import androidTestMod.powers.GetAllHandsPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class GetAllHandsAction extends AbstractGameAction {

    private AbstractCreature player;

    public GetAllHandsAction(AbstractCreature player){
        this.player = player;
    }

    @Override
    public void update(){
        boolean powerExists = false;

        for(AbstractCard c : AbstractDungeon.player.hand.group) {
            if(c.hasTag(CardTags.HAND)) {
                c.setCostForTurn(-9);
            }
        }

        for(AbstractPower pow : player.powers) {
            if (pow.ID.equals("GetAllHandsPower")) {
                powerExists = true;
                break;
            }
        }

        if (!powerExists) {
            this.addToBot(new ApplyPowerAction(player, player, new GetAllHandsPower(player)));
        }

        this.isDone=true;
    }

}
