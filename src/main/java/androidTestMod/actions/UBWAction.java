package androidTestMod.actions;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.combat.DaggerSprayEffect;

public class UBWAction extends AbstractGameAction {
    private int damage;

    public UBWAction( int damage) {
        this.damage = damage;
        this.actionType = ActionType.DAMAGE;
    }

    public void update(){
        this.isDone=true;

            int count = 0;

            for(AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
                if (c.hasTag(CardTagsEnum.BLADE) || c.cardID == "YiCut" || c.cardID == "Shiv") {
                    ++count;
                }
            }

            --count;
            for(int j=0;j<3;++j){
                this.addToBot(new VFXAction(new DaggerSprayEffect(AbstractDungeon.getMonsters().shouldFlipVfx()), 0.0F));
            }

             this.addToBot(new PlaySoundAction("UBW"));

            for(int i = 0; i < count; ++i) {
                this.addToBot(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, this.damage, DamageInfo.DamageType.NORMAL),AttackEffect.SLASH_HEAVY));
            }


    }

}
