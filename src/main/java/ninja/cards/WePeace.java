package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.actions.WePeaceAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class WePeace extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("WePeace");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/WePeace.png";
    public static final String ID = "WePeace";

    public WePeace(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.SELF);
        this.tags.add(CardTags.NINJUTSU);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
        this.isEthereal = true;
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToBot(new NinjutsuAction( p , new WePeaceAction( this.magicNumber ),1,"WePeace"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.isEthereal = false;
            this.rawDescription=cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new WePeace();
    }
}
