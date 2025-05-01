package ninja.cards;

import ninja.actions.GetAllHandsAction;
import ninja.actions.NinjutsuAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class GetAllHands extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GetAllHands");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/GetAllHands.png";
    public static final String ID = "GetAllHands";

    public GetAllHands(){
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.HAND);
        this.tags.add(CardTags.NINJUTSU);
        this.exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m){
        this.addToBot(new NinjutsuAction(p,new GetAllHandsAction(p),2,"GetAllHands"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    public AbstractCard makeCopy(){
        return new GetAllHands();
    }

}
