package androidTestMod.cards;

import androidTestMod.enums.CardColorEnum;

import androidTestMod.enums.LibraryTypeEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;

import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;
import java.util.List;

public class AnnaiMaster extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("AnnaiMaster");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/AnnaiMaster.png";
    public static final String ID = "AnnaiMaster";

    public AnnaiMaster() {
        super(ID, NAME, IMG_PATH, 1, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.exhaust = true;
        this.baseBlock = 4 ;
        this.baseMagicNumber= 3;
        this.magicNumber = baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        CardCrawlGame.sound.play("AnnaiMaster");
        // 1. 筛选所有忍术牌（需提前标记NINJUTSU标签）
        List<AbstractCard> ninjutsuCards = new ArrayList<>();
        for (AbstractCard c : CardLibrary.getCardList(LibraryTypeEnum.SILVER)) {
            if (c.tags.contains(CardTags.NINJUTSU) && c.rarity != CardRarity.BASIC) {
                ninjutsuCards.add(c);
            }
        }
        // 2. 随机选择一张忍术牌并生成临时实例
        if (!ninjutsuCards.isEmpty()) {
            int randomIndex = AbstractDungeon.cardRandomRng.random(ninjutsuCards.size() - 1);
            AbstractCard randomNinjutsu = ninjutsuCards.get(randomIndex).makeCopy();
            addToBot(new MakeTempCardInHandAction(randomNinjutsu,  1));
            // 3. 本回合耗能设为0（通过临时能力实现）
            randomNinjutsu.costForTurn = 0;
            randomNinjutsu.isCostModifiedForTurn = true;
        }

    }

    @Override
    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(0);
        }
    }

    public AbstractCard makeCopy(){
        return new AnnaiMaster();
    }

}
