package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;

public class BurningBladeAction extends AbstractGameAction {
    private DamageInfo info;
    private AbstractCard card;
    public BurningBladeAction(AbstractCard card, AbstractCreature target, DamageInfo info, AttackEffect effect) {
        this.info = info;
        this.card = card;
        this.setValues(target, info);
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = effect;
    }

    public void update() {
        this.addToTop(new VFXAction(AbstractDungeon.player, new InflameEffect(AbstractDungeon.player), 0.01F));
        if (this.target != null && this.target.currentHealth > 0) {
            int count = 1;

            for(AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
                if (c == this.card) {
                    ++count;
                }
            }

            --count;

            for(int i = 0; i < count; ++i) {

                this.addToBot(new DamageAction(this.target, this.info, this.attackEffect));
            }
        }


        this.isDone = true;
    }
}
