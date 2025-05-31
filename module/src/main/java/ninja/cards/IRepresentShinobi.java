package ninja.cards;

import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import ninja.powers.IRepresentShinobiPower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class IRepresentShinobi extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("IRepresentShinobi");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/IRepresentShinobi.png";
    public static final String ID = "IRepresentShinobi";

    public IRepresentShinobi(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 3, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.isEthereal=true;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        CardCrawlGame.sound.play(ID);
        this.addToBot(new ApplyPowerAction(p,p,new IRepresentShinobiPower(p,1),1));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.isEthereal=false;
            this.rawDescription=cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new IRepresentShinobi();
    }
}
