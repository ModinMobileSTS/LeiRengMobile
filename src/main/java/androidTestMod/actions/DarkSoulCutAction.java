package androidTestMod.actions;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import com.megacrit.cardcrawl.vfx.combat.FlyingOrbEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

public class DarkSoulCutAction extends AbstractGameAction {

    private AbstractCreature target;
    private int count;
    private int damage;
    private int maxhp;
    private DamageInfo info;
    private AttackEffect effect;

    public DarkSoulCutAction(AbstractCreature target, int count , int damage, int maxhp, DamageInfo info , AttackEffect effect){
        this.target = target;
        this.count = count;
        this.damage = damage;
        this.maxhp = maxhp;
        this.effect=effect;
        this.info=info;
    }

    public void update(){
        this.addToTop(new VFXAction(AbstractDungeon.player, new VerticalAuraEffect(Color.BLACK, AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 0.33F));
        this.addToTop(new SFXAction("ATTACK_FIRE"));
        this.addToTop(new VFXAction(AbstractDungeon.player, new VerticalAuraEffect(Color.PURPLE, AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 0.33F));
        this.addToTop(new VFXAction(AbstractDungeon.player, new VerticalAuraEffect(Color.CYAN, AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 0.0F));
        this.addToTop(new VFXAction(AbstractDungeon.player, new BorderLongFlashEffect(Color.MAGENTA), 0.0F, true));



        if (this.target != null && this.target.currentHealth > 0) {
            if(AbstractDungeon.player.hasRelic("Boot") && (this.damage <5 && this.damage>0)){
                if (15 >= this.target.currentHealth && !this.target.halfDead && !this.target.hasPower("Minion")) {
                    this.addToTop(new VFXAction(new FlyingOrbEffect(target.hb.cX, target.hb.cY)));
                    AbstractDungeon.player.increaseMaxHp(this.target.currentHealth, false);
                }
            }
            else {
                if (this.damage * 3 >= this.target.currentHealth && !this.target.halfDead && !this.target.hasPower("Minion")) {
                    this.addToTop(new VFXAction(new FlyingOrbEffect(target.hb.cX, target.hb.cY)));
                    AbstractDungeon.player.increaseMaxHp(this.target.currentHealth, false);
                }
            }

            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AttackEffect.NONE));
            for(int i =0;i<3;i++) {
                addToBot(new DamageAction(this.target, this.info, this.effect));
            }


            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }
        }


        this.isDone=true;
    }
}
