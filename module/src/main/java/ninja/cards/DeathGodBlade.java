package ninja.cards;

import ninja.actions.PlaySoundAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.DeathGodFlame;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.SmokeBombEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalAuraEffect;

public class DeathGodBlade extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DeathGodBlade");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/DeathGodBlade.png";
    public static final String ID = "DeathGodBlade";

    public DeathGodBlade(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), -2, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.tags.add(CardTags.BLADE);
        this.isMultiDamage = true;
        this.baseDamage = 20 ;
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.BLADE);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        if (this.dontTriggerOnUseCard) {
            this.addToTop(new LoseHPAction(AbstractDungeon.player, AbstractDungeon.player, this.magicNumber, AbstractGameAction.AttackEffect.FIRE));
        }
    }

    public void triggerOnExhaust() {
        this.addToBot(new PlaySoundAction("DeathGodBlade"));
        AbstractCreature p = AbstractDungeon.player;
        this.addToBot(new VFXAction(p, new VerticalAuraEffect(Color.BLACK, p.hb.cX, p.hb.cY), 0.33F));
        this.addToBot(new SFXAction("ATTACK_FIRE"));
        this.addToBot(new VFXAction(p, new VerticalAuraEffect(Color.PURPLE, p.hb.cX, p.hb.cY), 0.33F));
        this.addToBot(new VFXAction(p, new VerticalAuraEffect(Color.CYAN, p.hb.cX, p.hb.cY), 0.0F));
        this.addToBot(new VFXAction(p, new BorderLongFlashEffect(Color.MAGENTA), 0.0F, true));

        for(AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if (!mo.isDead && !mo.isDying) {
                this.addToBot(new ApplyPowerAction(mo,AbstractDungeon.player,new DeathGodFlame(mo,3),3));
                if(mo.hasPower("BeatOfDeath")) {
                    this.addToTop(new RemoveSpecificPowerAction(mo, p, "BeatOfDeath"));
                }
            }
        }

        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new IntangiblePlayerPower(AbstractDungeon.player, this.magicNumber), this.magicNumber));
        this.addToBot(new VFXAction(new SmokeBombEffect(AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY)));
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        return false;
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(8);
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new DeathGodBlade();
    }
}
