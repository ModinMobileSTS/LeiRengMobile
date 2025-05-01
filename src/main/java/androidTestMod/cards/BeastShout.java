package androidTestMod.cards;

import androidTestMod.actions.BeastShoutAction;
import androidTestMod.actions.NinjutsuAction;
import androidTestMod.actions.PlaySoundAction;
import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.ReaperEffect;
import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;

public class BeastShout extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BeastShout");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/BeastShout.png";
    public static final String ID = "BeastShout";

    public BeastShout(){
        super (ID, NAME, IMG_PATH, 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
        this.baseDamage = 12;
        this.tags.add(CardTags.NINJUTSU);
        this.isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToBot(new SFXAction("ATTACK_PIERCING_WAIL"));
        if (Settings.FAST_MODE) {
            this.addToBot(new VFXAction(p, new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 0.3F));
        } else {
            this.addToBot(new VFXAction(p, new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_TEXT_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 1.5F));
        }
        this.addToTop(new PlaySoundAction("BeastVoice"));
        this.addToBot(new VFXAction(new ReaperEffect()));
        this.addToBot(new DamageAllEnemiesAction(AbstractDungeon.player, this.multiDamage , DamageInfo.DamageType.NORMAL , AbstractGameAction.AttackEffect.NONE));
        this.addToBot(new NinjutsuAction( p , new BeastShoutAction( this.magicNumber ), 1 , "BeastShout"));
    }


    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.exhaust = false;
            this.rawDescription=cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new BeastShout();
    }
}
