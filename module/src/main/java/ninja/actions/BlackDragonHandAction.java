package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.combat.FlyingOrbEffect;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;


public class BlackDragonHandAction extends AbstractGameAction {
    private AbstractCreature target;
    private DamageInfo info;
    private AttackEffect effect;
    private int hp;

    public BlackDragonHandAction(AbstractCreature target, DamageInfo info, int hp, AttackEffect effect) {
        this.target = target;
        this.info = info;
        this.hp = hp;
        this.effect = effect;
    }

    public void update() {
        this.isDone = true;
        if (this.target.hasPower("Intangible")) {
            addToTop(new RemoveSpecificPowerAction(this.target, AbstractDungeon.player, "Intangible"));
        }
        AbstractDungeon.effectsQueue.add(new LightningEffect(this.target.hb.cX, this.target.hb.cY));
        CardCrawlGame.sound.playA("ORB_LIGHTNING_EVOKE", 0.9f);
        CardCrawlGame.sound.playA("ORB_LIGHTNING_PASSIVE", -0.3f);
        addToBot(new VFXAction(new FlyingOrbEffect(this.target.hb.cX, this.target.hb.cY)));
        if (this.target.maxHealth <= this.hp) {
            AbstractDungeon.player.increaseMaxHp(this.target.maxHealth, false);
            addToBot(new InstantKillAction(this.target));
        } else {
            this.target.decreaseMaxHealth(this.hp);
            AbstractDungeon.player.increaseMaxHp(this.hp, false);
        }
    }
}
