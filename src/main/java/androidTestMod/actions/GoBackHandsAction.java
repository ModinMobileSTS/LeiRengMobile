package androidTestMod.actions;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GoBackHandsAction extends AbstractGameAction {
    private AbstractPlayer p;
    private AbstractCard card;
    public GoBackHandsAction(AbstractCard card){
        this.p = AbstractDungeon.player;
        this.card = card;
        this.setValues(this.p, AbstractDungeon.player, this.amount);
        this.actionType = ActionType.CARD_MANIPULATION;
    }

    public void update(){
        if (this.p.discardPile.size() > 0) {
            for(AbstractCard card : this.p.discardPile.group) {
                if (card.hasTag(CardTags.HAND) && card != this.card ) {
                    card.setCostForTurn(0);
                    this.addToTop(new DiscardToHandAction(card));
                }
            }
        }
        this.isDone = true;
    }
}

