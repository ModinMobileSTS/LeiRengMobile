package androidTestMod.cards;

import androidTestMod.actions.FourNightsLightningAction;
import androidTestMod.actions.NinjutsuAction;
import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class FourNightsLightning extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FourNightsLightning");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/FourNightsLightning.png";
    public static final String ID = "FourNightsLightning";

    public FourNightsLightning() {
        super(ID, NAME, IMG_PATH, 4, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseDamage = 4 ;
        this.baseMagicNumber = 3;
        this.magicNumber = baseMagicNumber;
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use( AbstractPlayer p , AbstractMonster m ){
        for(int i=0 ; i<4 ;i++ ) {
            this.addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.LIGHTNING));
        }
        this.addToBot(new GainEnergyAction( 1 ));
        this.addToBot(new DrawCardAction( p , 1 ));
        this.addToBot(new NinjutsuAction( p , new FourNightsLightningAction( this , this.magicNumber ),4,"FourNightsLightning"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new FourNightsLightning();
    }
}
