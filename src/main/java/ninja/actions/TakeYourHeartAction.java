package ninja.actions;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.actions.utility.ShakeScreenAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.AdrenalineEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

public class TakeYourHeartAction extends AbstractGameAction {

    public TakeYourHeartAction(AbstractCreature target){
        this.target= target;
    }

    public void update(){
        if(this.target!= null && !this.target.hasPower("Artifact")) {
            this.addToBot(new PlaySoundAction("TakeYourHeart"));
            this.addToBot(new VFXAction(AbstractDungeon.player, new VerticalAuraEffect(Color.BLACK, AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 0.33F));
            this.addToBot(new SFXAction("ATTACK_FIRE"));
            this.addToBot(new VFXAction(AbstractDungeon.player, new VerticalAuraEffect(Color.PURPLE, AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 0.33F));
            this.addToBot(new VFXAction(AbstractDungeon.player, new VerticalAuraEffect(Color.CYAN, AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 0.0F));
            this.addToBot(new VFXAction(AbstractDungeon.player, new BorderLongFlashEffect(Color.MAGENTA), 0.0F, true));
            this.addToBot(new VFXAction(new AdrenalineEffect(), 0.15F));
            this.addToBot(new ShakeScreenAction(0.0F, ScreenShake.ShakeDur.MED, ScreenShake.ShakeIntensity.HIGH));
            this.addToBot(new DamageAction(this.target,new DamageInfo(AbstractDungeon.player,0, DamageInfo.DamageType.THORNS),AttackEffect.BLUNT_HEAVY));
            this.addToBot(new InstantKillAction(this.target));
        }

        this.isDone=true;
    }

}
