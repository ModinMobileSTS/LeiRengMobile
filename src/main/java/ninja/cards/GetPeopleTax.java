package ninja.cards;

import ninja.actions.GetTaxAction;
import ninja.actions.NinjutsuAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class GetPeopleTax extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GetPeopleTax");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/GetPeopleTax.png";
    public static final String ID = "GetPeopleTax";

    public GetPeopleTax(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseMagicNumber = 12;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
        this.tags.add(CardTags.NINJUTSU);
        this.baseDamage = 8;
        this.isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m){
        this.addToBot(new NinjutsuAction(p, new GetTaxAction(p , p , this.magicNumber , this.multiDamage),1 ,"GetPeopleTax"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(4);
            this.upgradeMagicNumber(3);
        }
    }

    public AbstractCard makeCopy(){
        return new GetPeopleTax();
    }
}
