package ninja.cards;

import ninja.actions.ScienceAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class PlayHearthStone extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("PlayHearthStone");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/PlayHearthStone.png";
    public static final String ID = "PlayHearthStone";

    public PlayHearthStone(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 4, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseBlock = 14;
        this.tags.add(CardTags.SCIENCE);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
                this.addToTop(new GainBlockAction(p,this.block));
        this.addToBot(new ScienceAction(p));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBlock(4);
        }
    }

    public AbstractCard makeCopy(){
        return new PlayHearthStone();
    }
}
