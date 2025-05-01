package androidTestMod.cards.template;

import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class PWR extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("PWR");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/POW.png";
    public static final String ID = "PWR";

    public PWR(){
        super (ID, NAME, IMG_PATH, 1, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){

    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
        }
    }

    public AbstractCard makeCopy(){
        return new PWR();
    }

}