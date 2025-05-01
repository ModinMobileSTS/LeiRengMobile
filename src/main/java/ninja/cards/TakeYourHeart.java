package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.actions.TakeYourHeartAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class TakeYourHeart extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("TakeYourHeart");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/TakeYourHeart.png";
    public static final String ID = "TakeYourHeart";

    public TakeYourHeart(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.ENEMY);
        this.tags.add(CardTags.HAND);
        this.tags.add(CardTags.NINJUTSU);
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToBot(new NinjutsuAction(p,new TakeYourHeartAction(m),10,""));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    public AbstractCard makeCopy(){
        return new TakeYourHeart();
    }
}
