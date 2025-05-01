package androidTestMod.cards;

import androidTestMod.actions.PlaySoundAction;
import androidTestMod.actions.ScienceAction;
import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.BlizzardEffect;

public class MambaMissile extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("MambaMissile");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/MambaMissile.png";
    public static final String ID = "MambaMissile";

    public MambaMissile() {
        super(ID, NAME, IMG_PATH, 3, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        this.baseDamage = 3 ;
        this.baseMagicNumber = 4 ;
        this.magicNumber = baseMagicNumber;
        this.tags.add(CardTagsEnum.SCIENCE);
        this.isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m){
        CardCrawlGame.sound.play("MambaMissile");
        AbstractPower lexkela = p.getPower("LexKela");
        for(int i=0;i<this.magicNumber;i++) {
            this.addToBot(new VFXAction(new BlizzardEffect(0, AbstractDungeon.getMonsters().shouldFlipVfx()), 0.1F));
            this.addToBot(new PlaySoundAction("Man!"));
            this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
        }
        if(p.hasPower("NinjaFlight")){
            this.addToBot(new PlaySoundAction("MambaOut"));
            this.addToBot(new RemoveSpecificPowerAction(p,p, "NinjaFlight"));
        }


        this.addToBot(new ScienceAction(p));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new MambaMissile();
    }
}
