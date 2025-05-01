package ninja.cards.template;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class ATK extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("ATK");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/ATT.png";
    public static final String ID = "ATK";

    public ATK(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){

    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
        }
    }

    public AbstractCard makeCopy(){
        return new ATK();
    }

}
